/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 - 2026 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import Sharee from 'sharee';

window.fcShareeConnector = {

	create: function (container, optionsJson) {
        this._updateXButtonLabel();
		this._updateCopyDriverOnClick();
		this._patchDriverNames();
		let parsedOptions = JSON.parse(optionsJson);
		const sharee = new Sharee(container, parsedOptions);
	},

	createWithCustomDrivers: function (container, optionsJson) {
        this._updateXButtonLabel();
		this._updateCopyDriverOnClick();
		this._patchDriverNames();
		let parsedOptions = JSON.parse(optionsJson);
		// add the custom drivers to the list of drivers
		let drivers = parsedOptions.drivers.concat(container.customDrivers);
		parsedOptions.drivers = drivers;
		const sharee = new Sharee(container, parsedOptions);
	},

	addCustomDriver(container, customDriverJson) {
		if (container.customDrivers == null) {
			container.customDrivers = [];
		}
		let parsedDriverOptions = JSON.parse(customDriverJson);
		const name = parsedDriverOptions.name;
		this._addDriver(name, parsedDriverOptions);
		container.customDrivers.push(name);
	},

	_addDriver(name, customDriverOptions) {
		var f = function (lang, options) {
			// get driver options saved before
			const driverOptions = this.constructor.driverOptions;
			const shareeOptions = options;

			this.lang = lang;
			this.options = shareeOptions;
			this.buttonText = driverOptions.buttonText;
			this.icon = driverOptions.icon;
			this.backgroundColor = driverOptions.backgroundColor;
			this.backgroundHoverColor = driverOptions.backgroundHoverColor;
			this.textColor = driverOptions.textColor;
			this.textHoverColor = driverOptions.textHoverColor;
			this.rippleColor = driverOptions.rippleColor;
			this.getLink = () => {
			    if(driverOptions.linkWithParams) {
			    	const shareLink = shareeOptions?.shareLink;
			    	const shareText = shareeOptions?.shareText;
	     			const shareLinkParam = driverOptions?.shareLinkParam;
	     			const shareTextParam = driverOptions?.shareTextParam;
					return driverOptions.link + "?" + shareLinkParam + "=" + shareLink + "&" + shareTextParam + "=" + shareText;
		    	} else {
		  		    return driverOptions.link;
		  		}
			}
			this.getButtonText = () => {
				return this.lang[this.buttonText.replaceAll(' ', '_')] || this.buttonText;
			}
			this.getName = () => {
				return driverOptions.name;
			}
			this.hasLink = () => !!driverOptions.link;
		};

		Object.defineProperty(f, 'name', { value: name });
		Object.defineProperty(f, 'driverOptions', { value: customDriverOptions });

		Sharee.addDriver(name, f);
	},	
	
	/**
	 * Replaces onClick function on CopyDriver to take in consideration shareLink option 
	 * if exists. (Fixes https://github.com/FlowingCode/ShareEasy/issues/8) 
	 */
	_updateCopyDriverOnClick() {
		Sharee.drivers['copy'].prototype.onClick = function(e) {
			// The copy driver copies a URL instead of navigating, so the shared
			// "link" is the text that gets copied (the base CopyDriver's getLink()
			// is undefined). Dispatch the same "driver-clicked" event the base
			// driver emits via super.onClick (lost when onClick is fully replaced
			// here), carrying the actual copied URL.
			const copyText = this.options?.shareLink || window.location.href
			const event = new CustomEvent('driver-clicked', {
				detail: {
					name: this.getName(),
					link: copyText,
					originalEvent: e,
				},
				bubbles: true,
				composed: true,
			});
			this.options?.targetElement.dispatchEvent(event);
			// Honor preventDefault as the base CopyDriver does after super.onClick.
			if (e.defaultPrevented) {
			  return
			}
		    const successText = this.lang['CopiedSuccessfully']
		    const el = e.currentTarget;
		    const textEl = el.querySelector('div:nth-child(2)')
		    if (textEl.innerHTML === successText) {
		      textEl.innerHTML = this.getButtonText()
		      return
		    }
		    navigator.clipboard.writeText(copyText).then(() => {
		      textEl.innerHTML = successText
		      textEl.style.transition = '300ms all'
		      textEl.style.transform = 'scale(1)'
		      textEl.style.transform = `scale(1.07) translateX(${this.lang.Direction === 'rtl' ? '-' : ''}4px)`
		      clearTimeout(this.timeout)
		      this.timeout = setTimeout(() => {
		        textEl.innerHTML = this.getButtonText()
		        textEl.style.transition = 'none'
		        textEl.style.transform = 'scale(1)'
		      }, 5000)
		    });
  		}
	},
    
    /*
     * Workaround to X driver button text to show only "X" instead "X.com" as in the base component.
     */
    _updateXButtonLabel() {
        Sharee.drivers['x'].prototype.getButtonText = function () {
            return "X";
        }
    },

	/**
	 * Overrides getName on each default driver so that it returns the driver's
	 * registered key (e.g. "telegram", "copy") instead of the bundled (and
	 * unstable) class name. This makes the name carried by the "driver-clicked"
	 * event reliable on the server side. Custom drivers already define their own
	 * getName in _addDriver, so they are not affected.
	 */
	_patchDriverNames() {
		Object.keys(Sharee.drivers).forEach(function (name) {
			Sharee.drivers[name].prototype.getName = function () {
				return name;
			};
		});
	}
}

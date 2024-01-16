/*-
 * #%L
 * Share Easy Add-on
 * %%
 * Copyright (C) 2023 - 2024 Flowing Code
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
		this._updateSocialShareLinks();
		let parsedOptions = JSON.parse(optionsJson);
		const sharee = new Sharee(container, parsedOptions);
	},

	createWithCustomDrivers: function (container, optionsJson) {
		this._updateSocialShareLinks();
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
		};

		Object.defineProperty(f, 'name', { value: name });
		Object.defineProperty(f, 'driverOptions', { value: customDriverOptions });

		Sharee.addDriver(name, f);
	},	

	/*
	 * Workaround because of issue https://github.com/parsagholipour/sharee/issues/2
	 * (to be removed when issue is fixed)
	 */
	_updateSocialShareLinks() {
		Sharee.drivers['facebook'].prototype.getLink = function () {
			return `https://facebook.com/sharer/sharer.php?u=${this.options?.shareLink}&t=${encodeURIComponent(this.options?.shareText)}`
		}
		Sharee.drivers['whatsapp'].prototype.getLink = function () {
			return `https://wa.me?text=${this.options?.shareText} \n ${this.options?.shareLink}`
		}
		Sharee.drivers['twitter'].prototype.getLink = function () {
			return `https://twitter.com/intent/tweet?text=${encodeURIComponent(this.options?.shareText)}&url=${this.options?.shareLink}`
		}
		Sharee.drivers['linkedin'].prototype.getLink = function () {
			return `https://www.linkedin.com/shareArticle?url=${this.options?.shareLink}`
		}
	},

}

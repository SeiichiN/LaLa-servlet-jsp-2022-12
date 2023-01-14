/**
 * 
 */
'use strict';

const password_box = document.querySelector('.password-box');
password_box.type = "password";
let mask = true;

const view_btn = document.querySelector('.view-btn');
view_btn.textContent = "(view)";
view_btn.onclick = function() {
	if (mask) {
		password_box.type = "text";
		view_btn.textContent = "(hide)";
		mask = false;
	} else {
		password_box.type = "password";
		view_btn.textContent = "(view)";
		mask = true;
	}
};
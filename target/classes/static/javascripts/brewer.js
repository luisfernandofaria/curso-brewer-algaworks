$(function() {
	let decimal = $('.js-decimal');
	decimal.maskMoney();
});

$(function() {
	let plain = $('.js-plain');
	plain.maskMoney({precision: 0});
});


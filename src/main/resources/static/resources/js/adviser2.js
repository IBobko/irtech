var headTag = document.getElementsByTagName("head")[0];
var jqTag = document.createElement('script');
jqTag.type = 'text/javascript';
jqTag.src = '/resources/js/require.js';
jqTag.setAttribute("data-main", "/resources/js/config.js");
headTag.appendChild(jqTag);




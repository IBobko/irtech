(function (parent) {
    var jsName = "adviser.js";

    function getLocation(href) {
        var match = href.match(/^(https?\:)\/\/(([^:\/?#]*)(?:\:([0-9]+))?)([\/]{0,1}[^?#]*)(\?[^#]*|)(#.*|)$/);
        return match && {
                protocol: match[1],
                host: match[2],
                hostname: match[3],
                port: match[4],
                pathname: match[5],
                search: match[6],
                hash: match[7]
            }
    }

    var scripts = document.getElementsByTagName("script");
    for (var index in scripts) {
        if (scripts[index].src != undefined && scripts[index].src.indexOf(jsName) != -1) {
            var loc = getLocation(scripts[index].src);
            parent.jsHostLocation = loc.protocol + "//" + loc.host;
            var headTag = document.getElementsByTagName("head")[0];
            var jqTag = document.createElement('script');
            jqTag.type = 'text/javascript';
            jqTag.src = parent.jsHostLocation + '/resources/js/external/require.js';
            jqTag.setAttribute("data-main", parent.jsHostLocation + "/resources/js/config/config.js");
            headTag.appendChild(jqTag);
            break;
        }
    }
})(this);
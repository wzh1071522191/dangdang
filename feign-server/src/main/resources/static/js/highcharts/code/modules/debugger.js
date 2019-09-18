/*
 Highcharts JS v7.1.2 (2019-06-03)

 Debugger module

 (c) 2012-2019 Torstein Honsi

 License: www.highcharts.com/license
*/
(function (a) {
    "object" === typeof module && module.exports ? (a["default"] = a, module.exports = a) : "function" === typeof define && define.amd ? define("highcharts/modules/debugger", ["highcharts"], function (b) {
        a(b);
        a.Highcharts = b;
        return a
    }) : a("undefined" !== typeof Highcharts ? Highcharts : void 0)
})(function (a) {
    function b(a, b, f, c) {
        a.hasOwnProperty(b) || (a[b] = c.apply(null, f))
    }

    a = a ? a._modules : {};
    b(a, "error-messages.js", [a["parts/Globals.js"]], function (a) {
        a.errorMessages = {
            10: {
                title: "Can't plot zero or subzero values on a logarithmic axis",
                text: "\x3ch1\x3eCan't plot zero or subzero values on a logarithmic axis\x3c/h1\x3e\x3cp\x3eThis error occurs in the following situations: \x3c/p\x3e\x3cul\x3e\x3cli\x3eIf a zero or subzero data value is added to a logarithmic axis\x3c/li\x3e\x3cli\x3eIf the minimum of a logarithimic axis is set to 0 or less\x3c/li\x3e\x3cli\x3eIf the threshold is set to 0 or less\x3c/li\x3e\x3c/ul\x3e\x3cp\x3eNote: As of Highcharts 5.0.8 it's possible to bypass this error message by setting \x3ccode\x3eAxis.prototype.allowNegativeLog\x3c/code\x3e to true, and add custom conversion functions. \x3ca href\x3d\"https://jsfiddle.net/gh/get/library/pure/highcharts/highcharts/tree/samples/highcharts/yaxis/type-log-negative/\"\x3eView live demo\x3c/a\x3e.\x3c/p\x3e",
                enduser: '\x3ch1\x3eCan\'t plot zero or subzero values on a logarithmic axis\x3c/h1\x3e\x3cp\x3eThis error occurs in the following situations:\x3c/p\x3e\x3cp\x3e* If a zero or subzero data value is added to a logarithmic axis\x3c/p\x3e\x3cp\x3e* If the minimum of a logarithimic axis is set to 0 or less\x3c/p\x3e\x3cp\x3e* If the threshold is set to 0 or less\x3c/p\x3e\x3cp\x3eAs of Highcharts 5.0.8 it\'s possible to bypass this error message by setting \x3ccode\x3eAxis.prototype.allowNegativeLog\x3c/code\x3e to \x3ccode\x3etrue\x3c/code\x3e and add custom conversion functions. \x3ca href\x3d"http://jsfiddle.net/gh/get/library/pure/highcharts/highcharts/tree/samples/highcharts/yaxis/type-log-negative/"\x3e"\x3eView Live Demo\x3c/a\x3e.\x3c/p\x3e'
            },
            11: {
                title: "Can't link axes of different type",
                text: "\x3ch1\x3eCan't link axes of different type\x3c/h1\x3e\x3cp\x3eThis error occurs when using the \x3ccode\x3elinkedTo\x3c/code\x3e option to link two axes of different types, for example a logarithmic axis to a linear axis. Highcharts can't link these because the calculation of ticks, extremes, padding etc. is different.\x3c/p\x3e"
            },
            12: {
                title: "Highcharts expects point configuration to be numbers or arrays in turbo mode",
                text: '\x3ch1\x3eHighcharts expects point configuration to be numbers or arrays in turbo mode\x3c/h1\x3e\x3cp\x3eThis error occurs if the series.data option contains object configurations and the number of points exceeds the turboThreshold. It can be fixed by either setting \x3ccode\x3eturboThreshold\x3c/code\x3e to a higher value, or changing the point configurations to numbers or arrays.\x3c/p\x3e\x3cp\x3eSee \x3ca href\x3d"https://api.highcharts.com/highcharts#plotOptions.series.turboThreshold"\x3eplotOptions.series.turboThreshold\x3c/a\x3e\x3c/p\x3e'
            },
            13: {
                title: "Rendering div not found",
                text: '\x3ch1\x3eRendering div not found\x3c/h1\x3e\x3cp\x3eThis error occurs if the \x3ca href\x3d"https://api.highcharts.com/highcharts#chart.renderTo"\x3echart.renderTo\x3c/a\x3e option is misconfigured so that Highcharts is unable to find the HTML element to render the chart in.\x3c/p\x3e\x3cp\x3eIf using a DOM ID when creating the chart, make sure a node with the same ID exists somewhere in the DOM.\x3c/p\x3e'
            },
            14: {
                title: "String value sent to series.data, expected Number",
                text: "\x3ch1\x3eString value sent to series.data, expected Number\x3c/h1\x3e\x3cp\x3eThis happens if using a string as a data point, for example in a setup like this: \x3c/p\x3e\x3cpre\x3eseries: [{\n    data: [\x26quot;3\x26quot;, \x26quot;5\x26quot;, \x26quot;1\x26quot;, \x26quot;6\x26quot;]\n}]\x3c/pre\x3e\x3cp\x3eHighcharts expects numerical data values.\x3c/p\x3e\x3cp\x3eThe most common reason for this error this is that data is parsed from CSV or\x3c/p\x3e\x3cp\x3efrom a XML source, and the implementer forgot to run \x3ccode\x3eparseFloat\x3c/code\x3e\x3c/p\x3e\x3cp\x3eon the parsed value.\x3c/p\x3e\x3cp\x3eNote: For performance reasons internal type casting is not performed, and only the first value is checked (since 2.3).\x3c/p\x3e"
            },
            15: {
                title: "Highcharts expects data to be sorted",
                text: "\x3ch1\x3eHighcharts expects data to be sorted\x3c/h1\x3e\x3cp\x3eThis happens when creating a line series or a stock chart where the data is not sorted in ascending X order.\x3c/p\x3e\x3cp\x3eFor performance reasons, Highcharts does not sort the data, instead it requires that the implementer pre-sorts the data.\x3c/p\x3e"
            },
            16: {
                title: "Highcharts already defined in the page",
                text: "\x3ch1\x3eHighcharts already defined in the page\x3c/h1\x3e\x3cp\x3eThis error happens if the \x3ccode\x3eHighcharts\x3c/code\x3e namespace already exists when loading\x3c/p\x3e\x3cp\x3eHighcharts or Highstock.\x3c/p\x3e\x3cp\x3eThis is caused by including Highcharts or Highstock more than once.\x3c/p\x3e\x3cp\x3eKeep in mind that the \x3ccode\x3eHighcharts.Chart\x3c/code\x3e constructor and all features of Highcharts are included in Highstock, so if using the \x3ccode\x3eChart\x3c/code\x3e and \x3ccode\x3eStockChart\x3c/code\x3e constructors in combination, only the \x3ccode\x3ehighstock.js\x3c/code\x3e file is required.\x3c/p\x3e"
            },
            17: {
                title: "The requested series type does not exist",
                text: "\x3ch1\x3eThe requested series type does not exist\x3c/h1\x3e\x3cp\x3eThis error happens when setting \x3ccode\x3echart.type\x3c/code\x3e or \x3ccode\x3eseries.type\x3c/code\x3e to a series type that isn't defined in Highcharts. A typical reason may be that the\x3c/p\x3e\x3cp\x3emodule or extension where the series type is defined isn't included.\x3c/p\x3e\x3cp\x3eFor example in order to create an \x3ccode\x3earearange\x3c/code\x3e series, the \x3ccode\x3ehighcharts-more.js\x3c/code\x3e file must be loaded.\x3c/p\x3e"
            },
            18: {
                title: "The requested axis does not exist",
                text: "\x3ch1\x3eThe requested axis does not exist\x3c/h1\x3e\x3cp\x3eThis error happens when setting a series' \x3ccode\x3exAxis\x3c/code\x3e or \x3ccode\x3eyAxis\x3c/code\x3e property to point to an axis that does not exist.\x3c/p\x3e"
            },
            19: {
                title: "Too many ticks",
                text: "\x3ch1\x3eToo many ticks\x3c/h1\x3e\x3cp\x3eThis error happens when applying too many ticks to an axis, specifically when adding more ticks than the axis pixel length.\x3c/p\x3e\x3cp\x3eWith default value this won't happen, but there are edge cases, for example when setting axis categories and \x3ccode\x3exAxis.labels.step\x3c/code\x3e in combination with a long data range, when the axis is instructed to create a great number of ticks.\x3c/p\x3e"
            },
            20: {
                title: "Can't add object point configuration to a long data series",
                text: "\x3ch1\x3eCan't add object point configuration to a long data series\x3c/h1\x3e\x3cp\x3eIn Highstock, when trying to add a point using the object literal configuration syntax, it will only work when the number of data points is below the series' \x3ca href\x3d\"https://api.highcharts.com/highstock#plotOptions.series.turboThreshold\"\x3eturboThreshold\x3c/a\x3e. Instead of the object syntax, use the Array syntax.\x3c/p\x3e"
            },
            21: {
                title: "Can't find Proj4js library",
                text: '\x3ch1\x3eCan\'t find Proj4js library\x3c/h1\x3e\x3cp\x3eUsing latitude/longitude functionality in Highmaps requires the \x3ca href\x3d"http://proj4js.org"\x3eProj4js\x3c/a\x3e library to be loaded.\x3c/p\x3e'
            },
            22: {
                title: "Map does not support latitude/longitude",
                text: '\x3ch1\x3eMap does not support latitude/longitude\x3c/h1\x3e\x3cp\x3eThe loaded map does not support latitude/longitude functionality. This is only supported with maps from the \x3ca href\x3d"https://code.highcharts.com/mapdata"\x3eofficial Highmaps map collection\x3c/a\x3e from version 1.1.0 onwards. If you are using a custom map, consider using the \x3ca href\x3d"https://proj4js.org"\x3eProj4js\x3c/a\x3e library to convert between projections.\x3c/p\x3e'
            },
            23: {
                title: "Unsupported color format used for color interpolation",
                text: "\x3ch1\x3eUnsupported color format used for color interpolation\x3c/h1\x3e\x3cp\x3eHighcharts supports three color formats primarily: hex (`#FFFFFF`), rgb (\x3ccode\x3ergba(255,255,255)\x3c/code\x3e) and rgba (\x3ccode\x3ergba(255,255,255,1)\x3c/code\x3e). If any other format, like 3-digit colors (`#FFF`), named colors (\x3ccode\x3ewhite\x3c/code\x3e) or gradient structures are used in for example a heatmap, Highcharts will fail to interpolate and will\x3c/p\x3e\x3cp\x3einstead use the end-color with no interpolation applied.\x3c/p\x3e\x3cp\x3eWe've chosen to preserve this limitation in order to keep the weight of the implementation at a minimum.\x3c/p\x3e"
            },
            24: {
                title: "Cannot run Point.update on a grouped point",
                text: "\x3ch1\x3eCannot run Point.update on a grouped point\x3c/h1\x3e\x3cp\x3eRunning \x3ccode\x3ePoint.update\x3c/code\x3e in Highstock when a point is grouped by data grouping is not supported.\x3c/p\x3e\x3cp\x3eThis is not supported because when data grouping is enabled, there won't be any\x3c/p\x3e\x3cp\x3ereferences to the raw points, which is required by the \x3ccode\x3ePoint.update\x3c/code\x3e function.\x3c/p\x3e"
            },
            25: {
                title: "Can't find Moment.js library",
                text: '\x3ch1\x3eCan\'t find Moment.js library\x3c/h1\x3e\x3cp\x3eUsing the global.timezone option requires the \x3ca href\x3d"https://momentjs.com/"\x3eMoment.js\x3c/a\x3e library to be loaded.\x3c/p\x3e'
            },
            26: {
                title: "WebGL not supported, and no fallback module included",
                text: "\x3ch1\x3eWebGL not supported, and no fallback module included\x3c/h1\x3e\x3cp\x3eThis happens when the browser doesn't support WebGL,\x3cb\x3eand\x3c/b\x3e the canvas fallback module (\x3ccode\x3eboost-canvas.js\x3c/code\x3e) hasn't been included OR if the fallback module was included\x3cb\x3eafter\x3c/b\x3e the boost module.\x3c/p\x3e\x3cp\x3eIf a fallback is required, make sure to include \x3ccode\x3eboost-canvas.js\x3c/code\x3e, and that it's included before \x3ccode\x3eboost.js\x3c/code\x3e.\x3c/p\x3e\x3cp\x3ePlease note that the fallback module is not intended as a fully-featured one. Rather, it's a minimal implementation of the WebGL counterpart.\x3c/p\x3e"
            },
            27: {
                title: "This browser does not support SVG",
                text: "\x3ch1\x3eThis browser does not support SVG\x3c/h1\x3e\x3cp\x3eThis happens in old IE when the \x3ccode\x3eoldie.js\x3c/code\x3e module isn't loaded.\x3c/p\x3e\x3cp\x3eIf compatibility with IE versions 6, 7 and 8 is required, add the module after\x3c/p\x3e\x3cp\x3eloading \x3ccode\x3ehighcharts.js\x3c/code\x3e. In a website context, it's a good idea to load it in a conditional comment to avoid traffic overhead and dead code in modern browsers: \x3c/p\x3e\x3cpre\x3e\x26lt;!--[if lt IE 9]\x26gt;\n    \x26lt;script src\x3d'https://code.highcharts.com/modules/oldie.js'\x26gt;\x26lt;/script\x26gt;\n\x26lt;![endif]--\x26gt;\x3c/pre\x3e"
            },
            28: {
                title: "Fallback to export server disabled",
                text: '\x3ch1\x3eFallback to export server disabled\x3c/h1\x3e\x3cp\x3eThis happens when the offline export module encounters a chart that it can\'t\x3c/p\x3e\x3cp\x3eexport successfully, and the fallback to the online export server is disabled. The offline exporting module will fail for certain browsers, and certain\x3c/p\x3e\x3cp\x3efeatures (e.g. \x3ca href\x3d"https://api.highcharts.com/highcharts/exporting.allowHTML"\x3eexporting.allowHTML\x3c/a\x3e ), depending on the type of image exporting to. For a compatibility overview, see \x3ca href\x3d"https://www.highcharts.com/docs/export-module/client-side-export"\x3eClient Side Export\x3c/a\x3e.\x3c/p\x3e\x3cp\x3eFor very complex charts, it\'s possible that exporting fail in browsers that don\'t support Blob objects, due to data URL length limits. It\'s always recommended to define the \x3ca href\x3d"https://api.highcharts.com/highcharts/exporting.error"\x3eexporting.error\x3c/a\x3e callback when disabling the fallback, so that details can be provided to the end-user if offline export isn\'t working for them.\x3c/p\x3e'
            },
            29: {
                title: "Browser does not support WebAudio",
                text: "\x3ch1\x3eBrowser does not support WebAudio\x3c/h1\x3e\x3cp\x3eThis happens when you attempt to use the sonification module on a chart in a browser or environment that does not support the WebAudio API. This API is supported on all modern browsers, including Microsoft Edge, Google Chrome and Mozilla Firefox.\x3c/p\x3e"
            },
            30: {
                title: "Invalid instrument",
                text: "\x3ch1\x3eInvalid instrument\x3c/h1\x3e\x3cp\x3eThis happens when you try to use a sonification instrument that is not valid. If you are using a predefined instrument, make sure your spelling is correct.\x3c/p\x3e"
            },
            31: {
                title: "Non-unique point or node id",
                text: "\x3ch1\x3eNon-unique point or node id\x3c/h1\x3e\x3cp\x3eThis error occurs when using the same \x3ccode\x3eid\x3c/code\x3e for two or more points or nodes.\x3c/p\x3e"
            },
            meta: {files: "errors/10/readme.md errors/10/enduser.md errors/11/readme.md errors/12/readme.md errors/13/readme.md errors/14/readme.md errors/15/readme.md errors/16/readme.md errors/17/readme.md errors/18/readme.md errors/19/readme.md errors/20/readme.md errors/21/readme.md errors/22/readme.md errors/23/readme.md errors/24/readme.md errors/25/readme.md errors/26/readme.md errors/27/readme.md errors/28/readme.md errors/29/readme.md errors/30/readme.md errors/31/readme.md".split(" ")}
        }
    });
    b(a, "modules/debugger.src.js", [a["parts/Globals.js"]], function (a) {
        var b = a.addEvent, f = a.isNumber, c = a.setOptions, g = a.each;
        c({chart: {displayErrors: !0}});
        b(a.Chart, "displayError", function (b) {
            var d = b.code, e = this.options.chart;
            b = this.renderer;
            var c;
            this.errorElements && g(this.errorElements, function (a) {
                a && a.destroy()
            });
            e && e.displayErrors && (this.errorElements = [], d = f(d) ? "Highcharts error #" + d + ": " + a.errorMessages[d].title + a.errorMessages[d].text : d, e = this.chartWidth, c = this.chartHeight, this.errorElements[0] =
                b.rect(2, 2, e - 4, c - 4).attr({
                    "stroke-width": 4,
                    stroke: "#ff0000",
                    zIndex: 3
                }).add(), this.errorElements[1] = b.label(d, 0, 0, "rect", null, null, !0).css({
                color: "#ffffff",
                width: e - 16,
                padding: 0
            }).attr({
                fill: "#ff0000",
                width: e,
                padding: 8,
                zIndex: 10
            }).add(), this.errorElements[1].attr({y: c - this.errorElements[1].getBBox().height}))
        });
        b(a.Chart, "beforeRedraw", function () {
            var a = this.errorElements;
            a && a.length && g(a, function (a) {
                a.destroy()
            });
            this.errorElements = null
        })
    });
    b(a, "masters/modules/debugger.src.js", [], function () {
    })
});
//# sourceMappingURL=debugger.js.map

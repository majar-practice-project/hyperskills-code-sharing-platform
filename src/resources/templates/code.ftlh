<html lang='en'>
    <head>
        <title>Code</title>
        <style>
            .green{
                color: green;
            }
            .code-snippet{
                border: 1px solid gray;
                border-radius: 2px;
                padding: 5px;
                background: lightgray;
            }
        </style>
        <link rel="stylesheet"
               href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <p><span id='load_date' class="green">${snippet.date}</span></p>
        <#if snippet.time??>
            <p><span id="time_restriction">${snippet.time}</span> more views allowed</p>
        </#if>
        <#if snippet.views??>
            <p>The code will be available for <span id="views_restriction">${snippet.views}</span> seconds</p>
        </#if>
        <div class="code-snippet">
            <pre id="code_snippet"><code>${snippet.code}</code></pre>
        </div>
    </body>
</html>
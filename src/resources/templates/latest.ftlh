<html lang="en">
    <head>
        <title>Latest</title>
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
        <#list codes as code>
            <span id='load_date' class="green">${code.date}</span>
            <div class="code-snippet">
                <pre id="code_snippet"><code>${code.code}</code></pre>
            </div>
            <br>
        </#list>
    </body>
</html>
<html>
<head>
    <title>Create</title>
    <style>
        #code_snippet{
            border: 1px solid gray;
            border-radius: 2px;
            padding: 5px;
            /*background: lightgray;*/
        }

    </style>
    <script>
        function send() {
            let object = {
                "code": document.getElementById("code_snippet").value,
                "time": document.getElementById("time_restriction").value,
                "views": document.getElementById("views_restriction").value
            };

            let json = JSON.stringify(object);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/code/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);

            if (xhr.status == 200) {
                alert("Success!");
            }
        }

    </script>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<textarea id="code_snippet" rows="6" cols="80" placeholder="Enter your code here..."></textarea>
<br><br>
    <Label for="time_restriction">Time restriction<input id="time_restriction" type="number"/></Label>
    <Label for="views_restriction">View restriction<input id="views_restriction" type="number"/></Label>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</body>
</html>
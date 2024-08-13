
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Axios GET Request Example</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<h1>Axios GET Request Example</h1>
<button id="getData">Get Data</button>
<pre id="responseData"></pre>

<script>
    document.getElementById('getData').addEventListener('click', () => {
        axios.get('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                document.getElementById('responseData').textContent = JSON.stringify(response.data, null, 2);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    });
</script>
</body>
</html>


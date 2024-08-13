<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Axios and jQuery GET Request Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        table, tr, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Axios and jQuery GET Request Example</h1>
<button id="getData">Get Data</button>
<button id="showData" disabled>Show JSON Data</button>
<div id="result">
</div>

<script>
    let jsonData = null;

    $('#getData').on('click', function() {
        $('#result').empty();
        axios.get('https://jsonplaceholder.typicode.com/posts', {
            headers: {
                'Accept': 'application/json'
            }
        })
            .then(function(response) {
                jsonData = response.data;

                $('#result').append('<pre>' + JSON.stringify(jsonData, null, 2) + '</pre>');
                $('#showData').prop('disabled', false);
            })
            .catch(function(error) {
                console.error('Error fetching data:', error);
            });
    });

    $('#showData').on('click', function() {
        $('#result').empty();
        const tableContainer = $('#result');

        if (jsonData) {

            // Create table rows
            jsonData.forEach(item => {
                const userId = item.userId;
                const id = item.id;
                const title = item.title;
                const body = item.body;
                const tr= '<tr><td>' + userId +
                    '</td><td>' + id +
                    '</td><td>' + title +
                    '</td><td>' + body + '</td></tr>';
                tableContainer.append(tr);
            });
            tableContainer.append('</table>');
        }
    });
</script>
</body>
</html>

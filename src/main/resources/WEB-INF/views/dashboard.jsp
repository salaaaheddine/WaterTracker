<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome to the Dashboard</h1>

    <!-- Display water intake history -->
    <h2>Water Intake History</h2>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Quantity (ml)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${waterIntakeHistory}">
                <tr>
                    <td>${entry.date}</td>
                    <td>${entry.amount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Form to record water intake -->
    <h2>Record Water Intake</h2>
    <form method="post" action="/dashboard/recordWater">
        <label for="quantity">Quantity (ml): </label>
        <input type="number" id="quantity" name="quantity" required>
        <button type="submit">Record</button>
    </form>
</body>
</html>

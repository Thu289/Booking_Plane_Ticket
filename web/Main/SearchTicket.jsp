
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="float: right">
    <tr>
        <td>Departure:</td>
        <td><input type="text" name="dep" value=""></td>
    </tr>
    <tr>
        <td>Destination:</td>
        <td><input type="text" name="des"></td>
    </tr>
    <tr>
        <td>Time from:</td>
        <td><input type="datetime-local" name="timeFrom"></td>
    </tr>
    <tr>
        <td>Time to:</td>
        <td><input type="datetime-local" name="timeTo"></td>
    </tr>
    <tr>

    </tr>
    <tr>
        <td>Supplier:</td>
        <td>
            <select name="type">
                <c:forEach items="${DAO.getSupplier()}" var="acc">
                    <option value="${acc.getId()}">${acc.getName_supplier()}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Search"></td>
    </tr>
</table>
<script>
    function updateTextInput(val) {
        document.getElementById('textInput').value = val;
    }
</script>

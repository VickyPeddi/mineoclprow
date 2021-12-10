function exportExcel(sTableId, repSubmitPage)
{
    var columnNms = $("#" + sTableId).jqGrid('getGridParam', 'colNames');
    var theads = "";
    for (var cc = 0; cc < columnNms.length; cc++) {
        theads = theads + "<th>" + columnNms[cc] + "</th>"

    }
    theads = "<tr>" + theads + "</tr>";
    var html = "<html><head><style script='css/text'>table.tableList_1 th {border:1px solid #a8da7f; border-bottom:2px solid #a8da7f; text-align:center; vertical-align: middle; padding:5px; background:#e4fad0;}table.tableList_1 td {border:1px solid #a8da7f; text-align: left; vertical-align: top; padding:5px;}</style></head><body><table border='" + ('0') + "' class='tableList_1 t_space' cellspacing='10' cellpadding='0'>" + theads;
    var oTable = document.getElementById(sTableId);
    var rowLength = oTable.rows.length;
    for (i = 0; i < rowLength; i++) {
        html = html + "<tr>";
        var oCells = oTable.rows.item(i).cells;
        var cellLength = oCells.length;
        for (var j = 0; j < cellLength; j++) {

            html = html + "<td>" + oCells.item(j).innerHTML + "</td>";
        }
        html = html + "</tr>";
    }

    html = html + "</table></body></html>";
    document.getElementById("dataExport").value = html;
    document.forms[repSubmitPage].method = 'POST';
    document.forms[repSubmitPage].action = './Reports/download.jsp';
    document.forms[repSubmitPage].submit();
}

function checkFileType(objFileControl) {
    var file = objFileControl.value;
    var len = file.length;
    var ext = file.slice(len - 4, len);
    if (ext.toUpperCase() === ".PDF" || ext.toUpperCase() === ".JPG" || ext.toUpperCase() === "JPEG") {
        return true;
    }
    else {
        return false;
    }
}
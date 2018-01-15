function loadPuzzle(sortType){
    $('#puzzleDiv').html('');
    $.getJSON("http://localhost:8080/lab6/resources/puzzle/list", {'sort': sortType} ,function(data){
        var table = $("<table>").addClass("puzzleTable").appendTo($('#puzzleDiv'));
        var row = $('<tr>').appendTo(table);

        addHeaderRowElement(row, "Nazwa", "names");
        addHeaderRowElement(row, "Powierzchnia", "surface");
        addHeaderRowElement(row, "Liczba elementów", "numberOfElements");
        $('<td>').text("Usuń").appendTo(row);
        $('<td>').text("Szczegóły").appendTo(row);
        
        $.each(data, function (i, puzzle) {
            var row = $('<tr>').appendTo(table);
            $('<td>').text(puzzle.name).appendTo(row);
            $('<td>').text(Number(puzzle.width * puzzle.height).toFixed(2)).appendTo(row);
            $('<td>').text(puzzle.numberOfElements).appendTo(row);
            
            var deleteButton = $('<button>').attr('onClick', 'remove(' + puzzle.id + ')').text("Usuń");
            var deleteTd = $('<td>').appendTo(row);
            deleteButton.appendTo(deleteTd);
            var detailsButton = $('<button>').attr('onClick', 'details(' + puzzle.id + ')').text("Pokaż");
            var detailsTd = $('<td>').appendTo(row);
            detailsButton.appendTo(detailsTd);
            
        });
    });
}

function addHeaderRowElement(row, name, sort){
    var td = $('<td>').appendTo(row);
    var button = $('<button>').attr('onClick', 'loadPuzzle(\"' + sort + '\")').text(name);
    button.appendTo(td);
}

function remove(id){
    $.ajax({
        url: 'http://localhost:8080/lab6/resources/puzzle/' + id,
        type: 'DELETE'
    });
    loadPuzzle("names");
}

function details(id){
    $('#detailsDiv').html('');
    $.getJSON("http://localhost:8080/lab6/resources/puzzle/" + id ,function(puzzle){
        var div = $('#detailsDiv');
        //$('<img>').attr('src', iconUrl).appendTo(div);
        $('<div>').text("Nazwa: " + puzzle.name).appendTo(div);
        $('<div>').text("Wysokość: " + puzzle.height).appendTo(div);
        $('<div>').text("Szerokość: " + puzzle.width).appendTo(div);
        $('<div>').text("Powierzchnia: " + puzzle.width * puzzle.height).appendTo(div);
        $('<div>').text("Liczba elementów: " + puzzle.numberOfElements).appendTo(div);
    });
    loadPuzzle("names");
}

$(document).ready(function () {
    loadPuzzle("none");
});

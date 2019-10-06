(function($) {
	$(document).ready( function () {

        $.getJSON("http://localhost:8442/libros", function(data){
            console.log(data);
            $('#tabla_disponibles').DataTable({
                data: data,
                responsive: true,
                rowId: 'idLibro',
                columns: [
                { data: "idLibro" , visible:false},
                { data: "titulo" } ,
                { data: "isbn" } ,
                { data: "total" },
                { data: "cantidad"},
                { data: "fecha"}
                ]
            });
        });
    
        function createLibro(){
            $("#btn_agregar_libro").onClick(function(e){
                $.ajax({
                    
                })
            });
        }

        $.ajax({
            type: "POST",
            contentType : "application/json",
            url: "localhost:8442/libros/",
            dataType : 'json',
        });
		  
	});
})(jQuery); // End of use strict
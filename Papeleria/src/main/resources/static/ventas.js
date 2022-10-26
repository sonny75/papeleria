document.addEventListener("DOMContentLoaded", () => {
    const venta = document.querySelector("#ventas");
    const ventasForm = document.querySelector("#create-ventas");
    console.log("Lo que trae la variable:", ventasForm);
    //console.log("Lo que trae la variable:",ventas);
   ventasForm.addEventListener('submit', createventas);
    fetch("http://localhost:8080/ventas/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(ventas => ventas.forEach(slapItOnTheDOM))
    //.then(console.log())
    function slapItOnTheDOM(ventas) {
        //console.log("Inicia mostrando el listado de roles");
        const ventasLi = document.createElement("li");
        console.log (ventas); 
       ventasLi.dataset.idVentas = ventas.idventas;
       ventasLi.innerHTML = '<span>' +ventas.papeleria.nombrepapeleria
                + '-' + ventas.usuario.nombreuno +'-'
                + ventas.fecharegistro
                + '-' 
        '</span>';
       venta.appendChild(ventasLi);
        //console.log("Identificador de Rol", rolLi.dataset.id); 
    }
    function createventas(event) {
        console.log('Inicia creacion');
        event.preventDefault();
        let nuevoVentas = reunirFormData();
        return fetch("http://localhost:8080/ventas/",{
            method:"POST",
            headers: {
                'Content-Type':'application/json',
                'Accept':'application/json'
            },

            body: JSON.stringify(nuevoVentas)
        })
                .then(res => res.json())
               .then(ventas => (slapItOnTheDOM(ventas)))
    }
    function reunirFormData() {
        return{
            idventa: event.target.idventa.value,
              papeleria: {
            idpapeleria: event.target.idpapeleria.value
              },
              usuario: {
            idusuario: event.target.idusuario.value
              } ,
            
            fecharegistro: event.target.fecharegistro.value
           
        }
    }
})



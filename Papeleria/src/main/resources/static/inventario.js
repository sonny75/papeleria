document.addEventListener("DOMContentLoaded",() =>{
    const inventarios = document.querySelector("#inventarios");
    const inventarioForm = document.querySelector("#create-inventario");
    console.log("Lo que trae la variable:",inventarioForm);
    //console.log("Lo que trae la variable:",inventario);
    inventarioForm.addEventListener('submit', createInventario);
    fetch("http://localhost:8080/inventario/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(inventario => inventario.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(inventario){
        //console.log("Inicia mostrando el listado de inventarios");
        const inventarioLi = document.createElement("li");
        inventarioLi.dataset.idinventario = inventario.idinventario;
        inventarioLi.innerHTML = '<span>'+inventario.producto.idproducto
                + '-' + inventario.provedor.idproveedor
                + '-' + inventario.fecharegistro 
                + '-' + inventario.cantidad
                + '-' + inventario.valorunitario
                + '-' + inventario.ventas.idventa;
                '</span>';
        inventarios.appendChild(inventarioLi);
        //console.log("Identificador de inventario", inventarioLi.dataset.id);
    }
    function createInventario(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevoinventario=reunirFormData();
        return fetch("http://localhost:8080/inventario/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevoinventario)
        })
                .then(res => res.json())
                .then(inventario => (slapItOnTheDOM(inventario)))
    }
    function reunirFormData(){
        return {
            idinventario:event.target.idinventario.value,
            producto:{idproducto:event.target.idproducto.value},
            provedor:{idproveedor:event.target.idproveedor.value},
            fecharegistro:event.target.fecharegistro.value,
            cantidad:event.target.cantidad.value,
            valorunitario:event.target.valorunitario.value,
            ventas:{
                idventa:event.target.codigoventa.value
            }
        }
    }
})



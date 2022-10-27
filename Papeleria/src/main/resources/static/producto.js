document.addEventListener("DOMContentLoaded",() =>{
    const productos = document.querySelector("#productos");
    const productoForm = document.querySelector("#create-producto");
    console.log("Lo que trae la variable:",productoForm);
    //console.log("Lo que trae la variable:",producto);
    productoForm.addEventListener('submit', createProducto);
    fetch("http://localhost:8080/producto/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(producto => producto.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(producto){
        //console.log("Inicia mostrando el listado de productos");
        const productoLi = document.createElement("li");
        productoLi.dataset.idproducto = producto.idproducto;
        productoLi.innerHTML = '<span>'+producto.descripcionproducto
                + '-' + producto.categoria.idCategoria 
                + '-' + producto.provedor.idproveedor 
                +'</span>';
        productos.appendChild(productoLi);
        //console.log("Identificador de producto", productoLi.dataset.id);
    }
    function createProducto(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevoproducto=reunirFormData();
        return fetch("http://localhost:8080/producto/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevoproducto)
        })
                .then(res => res.json())
                .then(producto => (slapItOnTheDOM(producto)))
    }
    function reunirFormData(){
        return {
            idproducto:event.target.idproducto.value,
            descripcionproducto:event.target.descripcionproducto.value,
            categoria:{idCategoria:event.target.idcategoria.value},
            provedor:{idproveedor:event.target.idproveedor.value}
        }
    }
})




document.addEventListener("DOMContentLoaded",() =>{
    const categorias = document.querySelector("#categorias");
    const categoriaForm = document.querySelector("#create-categoria");
    console.log("Lo que trae la variable:",categoriaForm);
    //console.log("Lo que trae la variable:",proveedores);
    categoriaForm.addEventListener('submit', createCategoria);
    fetch("http://localhost:8080/categoria/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(categoria => categoria.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(categoria){
        //console.log("Inicia mostrando el listado de roles");
        const categoriaLi = document.createElement("li");
        categoriaLi.dataset.idCategoria = categoria.idCategoria;
        categoriaLi.innerHTML = '<span>'+categoria.nombre;//+ '-' + proveedor.email_proveedor + '</span>';
        categorias.appendChild(categoriaLi);
        //console.log("Identificador de Rol", rolLi.dataset.id);
    }
    function createCategoria(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevoCategoria=reunirFormData();
        return fetch("http://localhost:8080/categoria/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevoCategoria)
        })
                .then(res => res.json())
                .then(categoria => (slapItOnTheDOM(categoria)))
    }
    function reunirFormData(){
        return {
            idCategoria:event.target.idCategoria.value,
            nombre:event.target.nombre.value
        }
    }
})




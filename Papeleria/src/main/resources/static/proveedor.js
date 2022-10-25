document.addEventListener("DOMContentLoaded", () => {
    const proveedores = document.querySelector("#proveedores");
    const proveedorForm = document.querySelector("#create-proveedor");
    console.log("Lo que trae la variable:", proveedorForm);
    //console.log("Lo que trae la variable:",proveedores);
    proveedorForm.addEventListener('submit', createProveedor);
    fetch("http://localhost:8080/proveedor/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(proveedor => proveedor.forEach(slapItOnTheDOM))
    //.then(console.log())
    function slapItOnTheDOM(proveedor) {
        //console.log("Inicia mostrando el listado de roles");
        const proveedorLi = document.createElement("li");
        proveedorLi.dataset.idProveedor = proveedor.idproveedor;
        proveedorLi.innerHTML = '<span>' +proveedor.empresa 
                + '-' + proveedor.emailproveedor +'-'
                + proveedor.celularproveedor
                + '-' + proveedor.direccionempresa
                + '-' + proveedor.nombrevendedor;
        '</span>';
        proveedores.appendChild(proveedorLi);
        //console.log("Identificador de proveedor", proveedorLi.dataset.id); 
    }
    function createProveedor(event) {
        console.log('Inicia creacion');
        event.preventDefault();
        let nuevoProveedor = reunirFormData();
        return fetch("http://localhost:8080/proveedor/",{
            method:"POST",
            headers: {
                'Content-Type':'application/json',
                'Accept':'application/json'
            },

            body: JSON.stringify(nuevoProveedor)
        })
                .then(res => res.json())
               .then(proveedor => (slapItOnTheDOM(proveedor)))
    }
    function reunirFormData() {
        return{
            idproveedor: event.target.idproveedor.value,
            empresa: event.target.empresa.value,
            celularproveedor: event.target.celularproveedor.value,
            emailproveedor: event.target.emailproveedor.value,
            direccionempresa: event.target.direccionempresa.value,
            nombrevendedor: event.target.nombrevendedor.value
        }
    }
})

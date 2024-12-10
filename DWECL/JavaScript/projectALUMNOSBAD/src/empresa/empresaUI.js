import { crearEmpresa, obtenerEmpresas, eliminarEmpresa } from './empresaController.js';

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('form-alta-empresa');
    const tablaEmpresas = document.getElementById('tabla-empresas').querySelector('tbody');

    // Función para renderizar la tabla
    const renderTablaEmpresas = () => {
        const empresas = obtenerEmpresas();
        console.log(empresas);

        tablaEmpresas.innerHTML = '';
        empresas.forEach(empresa => {
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${empresa.id}</td>
                <td>${empresa.nombre}</td>
                <td>${empresa.direccion}</td>
                 <td>
                    <button class="editar" data-id="${empresa.id}" id="editar${empresa.id}">Editar</button>
                    <button class="eliminar" data-id="${empresa.id}" id="eliminar${empresa.id}">Eliminar</button>
                </td>
            `;
            tablaEmpresas.appendChild(fila);
            
            // Asignar eventos a los botones de editar y eliminar
            // Los he asignado individualmente a cada botón en vez de a todos los que tengan la clase
            document.querySelector(`#editar${empresa.id}`).addEventListener('click', (e) => {
                    alert(`Editar empresa`);
                    const empresaId = e.target.dataset.id;
                    // Lógica para editar la empresa
                    const index = empresas.findIndex(empresa => empresa.id === empresaId);
                        if (index !== -1) {
                            
                        }
                    alert(`Editar empresa con ID: ${empresaId}`);
                    // Aquí puedes cargar los datos en un formulario para editar
                    
            });
        
            document.querySelector(`#eliminar${empresa.id}`).addEventListener('click', (e) => {
                    alert(`Eliminar empresa`);
                    const empresaId = e.target.dataset.id;
                    
                    alert(`Eliminar empresa con ID: ${empresaId}`);
                    eliminarEmpresa(empresaId);
                    renderTablaEmpresas(); // Recargar la tabla después de eliminar
            });
        });
    };
    
    
    
    // Manejo del formulario
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const nombre = form.nombre.value;
        const direccion = form.direccion.value;
        
        crearEmpresa(nombre, direccion);
        renderTablaEmpresas();
        
        // Limpiar el formulario
        form.reset();
    });

    // Cargar la tabla inicialmente
    renderTablaEmpresas();
});
    
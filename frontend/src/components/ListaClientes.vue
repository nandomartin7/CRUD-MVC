<template>
    <div>
        <h2>Lista de Clientes</h2>
        <ul>
            <li v-for="cliente in clientes" :key="cliente.idCliente">
                {{ cliente.nombre }} {{ cliente.apellido }}
                <button @click="deleteCliente(cliente.idCliente)">Eliminar</button>
            </li>
        </ul>
        <router-link to="/formulario-cliente">Agregar Cliente</router-link>
    </div>
</template>

<script>
import axios from 'axios';

export default{
    data(){
        return{
            clientes: []
        };
    },

    methods:{
        getClientes() {
      axios.get('http://localhost:8080/clientes')
        .then(response => {
          this.clientes = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    deleteCliente(id) {
      axios.delete(`http://localhost:8080/clientes/${id}`)
        .then(() => {
          this.getClientes(); // Refresca la lista después de eliminar
        })
        .catch(error => {
          console.error(error);
        });
    }
  },
  mounted() {
    this.getClientes();
  }
};
</script>
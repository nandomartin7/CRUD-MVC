<template>
    <div>
      <h2>Agregar Cliente</h2>
      <form @submit.prevent="submitForm">
        <input v-model="cliente.nombre" placeholder="Nombre" required />
        <input v-model="cliente.apellido" placeholder="Apellido" required />
        <input v-model="cliente.cedula" placeholder="Cédula" required />
        <input v-model="cliente.correo" placeholder="Correo" required />
        <input v-model="cliente.direccion" placeholder="Dirección" required />
        <input v-model="cliente.telefono" placeholder="Teléfono" required />
        <button type="submit">Guardar</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        cliente: {
          nombre: '',
          apellido: '',
          cedula: '',
          correo: '',
          direccion: '',
          telefono: ''
        }
      };
    },
    methods: {
      submitForm() {
        axios.post('http://localhost:8080/clientes', this.cliente)
          .then(() => {
            this.$router.push('/'); // Regresar a la lista de clientes después de guardar
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>
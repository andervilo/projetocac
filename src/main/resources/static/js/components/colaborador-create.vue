<template>	
    <q-page-container >
        <q-page padding>
                <div class="q-headline text-weight-light">Novo Colaborador</div>
            <div class="row">	            
                <div class="col-sm-8 col-md-8 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.nome" float-label="Nome"   />
                </div> 
                <div class="col-sm-4 col-md-4 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.cpfOuCnpj" float-label="CPF/CNPJ"   />
                </div> 
                <div class="col-sm-5 col-md-5 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.logradouro" float-label="Endereço"   />
                </div> 
                <div class="col-sm-2 col-md-2 col-xs-3 q-px-md">
                    <q-input  v-model="colaborador.numero" float-label="Número"   />
                </div> 
                <div class="col-sm-3 col-md-3 col-xs-5 q-px-md">
                    <q-input  v-model="colaborador.bairro" float-label="Bairro"   />
                </div> 
                <div class="col-sm-2 col-md-2 col-xs-4 q-px-md">
                    <q-input  v-model="colaborador.cep" float-label="CEP"   />
                </div> 
                 <div class="col-12 q-px-md">
                    <q-input  v-model="colaborador.complemento" float-label="Complemento"   />
                </div>
                <div class="col-sm-4 col-md-4 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.celular" float-label="Celular"   />
                </div>
                <div class="col-sm-4 col-md-4 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.email" float-label="E-mail"   />
                </div>
                <div class="col-sm-4 col-md-4 col-xs-12 q-px-md">
                    <q-input  v-model="colaborador.profissao" float-label="Profissão"   />
                </div>
            </div> 
        </q-page>	
    </q-page-container>

</template>

<script>
  module.exports = { 
      
    data() {
      return {
          colaborador:{
              nome:"",
              logradouro:"",
              numero:"",
              bairro:"",
              cep:"",
              complemento:"",
              celular:"",
              email:"",
              profissao:"",
              cpfOuCnpj:""
            }

      }
    }, 

    methods: {  
        findAll() {
            axios
            .get('/api/v1/colaboradores')
            .then(response => {this.tableData = response.data})
            .catch(error => console.log(error))
        }      
    },

    mounted() {
        this.findAll()
    }
  }
</script>
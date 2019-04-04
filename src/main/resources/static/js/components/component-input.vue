<template>
	
  <div>
    <p>here ur input: {{ message }}</p> <!--     這是資料雙向綁定效果(v-model) -->
    <p><input 
          :class="{ focus: isFocus }" 
          v-model="message" 
          @focus="focus" 
          @blur="blur"></p>
  </div>

</template>

<script>
  module.exports = { 
    data() {
      return {
        isFocus: false, 
        message: 'default value'
      }
    }, 
    methods: {
      focus() {
        this.isFocus = true;
      }, 
      blur() {
        this.isFocus = false;
      }      
    }
  }
</script>

<style scoped>
  .focus {
    border: 2px #FFAC55 solid;
  }
</style>
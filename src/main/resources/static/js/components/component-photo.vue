<template>
	
  <div>
    <img :src="url" style="max-height:120px"> (for the Demo; max height 120px)
    <p><input v-model="url" style="width:500px"></p>
  </div>

</template>

<script>
  module.exports = {
    data() {
      return {
        url: 'http://via.placeholder.com/350x150' 
      }
    }
  }
</script>

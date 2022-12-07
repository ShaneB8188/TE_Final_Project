<template>
   <div class="content">
  <div id="login" class="text-center">
    
      <h1 class="h3 mb-3 font-weight-normal" align="center">Cart</h1>
     
      
      
      <router-link :to="{ name: 'menu' }">Return to Menu</router-link>
      <button type="submit" class="checkoutBtn">Checkout</button>
    
  </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.content {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}


.checkoutBtn {
  
  align-content: space-around;
  
  width: 50%;
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #27b055, #064d15);
  border: 0;
  padding-left: 40px;
  padding-right: 40px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-family: "Ubuntu", sans-serif;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
  align-items: center;
  align-self: center;
  margin-top: 10px;
  margin-bottom: 24px;
}
</style>
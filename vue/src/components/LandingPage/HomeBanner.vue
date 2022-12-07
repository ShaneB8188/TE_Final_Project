<template>
  <section>
    <div id="home">Home</div>
    <div id="employee-login">Employee Login</div>
    <div id="cart">Cart</div>
  </section>
</template>

<script>
export default {};
</script>

<style>
section{
  display: flex;
  justify-content: flex-end;
  background-color: rgba(255,0,0);
  color: white;

}

#home{
  margin: 10px;
  
}
#home:hover{
  cursor: pointer;
  background-color: rgb(122, 6, 6);
  margin: 10px;
}
#employee-login:hover{
  cursor: pointer;
  background-color: rgb(122, 6, 6);
  margin: 10px;
}
#cart:hover{
  cursor: pointer;
  background-color: rgb(122, 6, 6);
  margin: 10px;
}


#employee-login{
margin: 10px


}

#cart{
  margin: 10px;
}

</style>
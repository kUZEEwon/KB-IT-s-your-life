<template>

  <div id="app">
    <!-- header -->
    <header>

    </header>

    <!-- navbar -->

    <nav class="navbar navbar-expand-md navbar-dark bg-info sticky-top">
      <div class='container text-center'>

        <div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a href="/" class='nav-link'>Home</a>
            </li>
            <li class="nav-item">
              <a href="/bbslist" class='nav-link' to="/bbslist">게시판</a>
            </li>
          </ul>
          <ul class="navbar-nav">
            <li class="nav-item">
              <a href="/login" class='nav-link' to="/login">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Main -->
    <Main />

    <!-- Footer -->
    <footer className="py-4 bg-info text-light">
      <div className="container text-center">
        <ul className="nav justify-content-center mb-3">

          <li className='nav-item'>
            <a className='nav-link' href='/'>Top</a>
          </li>

        </ul>
        <p>
          <small>Copyright &copy;Graphic Arts</small>
        </p>
      </div>
    </footer>

  </div>

</template>

<script>
import Main from "./views/Main.vue"

export default {
  name: 'App',
  components: {
    Main
  }
}
</script>


<style>
#app {
  margin:0 auto;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;  
} 

header{
  margin:0 auto;
  background-image: url("./assets/header.jpg");
  background-position: center center;
  width: 2000px;
  height: 120px;
  background-size : cover;
} 

/* 네비바의 간격 조절 */
.navbar-nav > li{  
  padding-left:20px;
  padding-right:20px;
}                                  
</style>

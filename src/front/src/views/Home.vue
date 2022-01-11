<template>
  <h2>Home</h2>

  <div class="container">
    <img class="pie" src="../assets/chart1.png" alt="chart1" />
    <img class="pie" src="../assets/chart1.png" alt="chart2" />
    <br />
    <img class="line" src="../assets/chart2.png" alt="chart3" />
  </div>
</template>

<script>
export default {
  name: "Home",
};
</script>
<style scoped>
.container img:nth-child(2) {
  float: right;
  margin-right: 10%;
}
.pie {
  height: 200px;
  width: 200px;
}
.line {
  width: 800px;
  height: 600px;
}
</style>
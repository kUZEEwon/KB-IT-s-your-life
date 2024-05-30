<template>
  <div class="container mt-5 btn btn-outline-success">
    <h1 class="text-bg-secondary text-danger">FLOWER ORDER</h1>
    <div class="mb-3">
      <label for="flowerName" class="form-label">꽃 이름</label>
      <input type="text" v-model="order.flowerName" class="form-control" id="flowerName" placeholder="예: sun, rose">
    </div>
    <div class="mb-3">
      <label for="flowerPrice" class="form-label">꽃 가격</label>
      <input type="number" v-model="order.flowerPrice" class="form-control" id="flowerPrice" placeholder="예: 5000">
    </div>
    <div class="mb-3">
      <label for="flowerQuantity" class="form-label">꽃 수량</label>
      <input type="number" v-model="order.flowerQuantity" class="form-control" id="flowerQuantity" placeholder="예: 2">
    </div>
    <button class="btn btn-primary" @click="placeOrder">주문</button>

    <div v-if="isOrderPlaced" class="mt-4">
      <p>{{ order.flowerName }}의 가격은 {{ totalPrice }}원입니다.</p>
      <img v-if="flowerImage" :src="flowerImage" alt="Flower Image" class="img-fluid" />
    </div>
  </div>
</template>

<script>
import { reactive, ref, watch } from 'vue';

export default {
  name: 'FlowerOrder',
  setup() {
    const order = reactive({
      flowerName: '',
      flowerPrice: 0,
      flowerQuantity: 0
    });

    const isOrderPlaced = ref(false);
    const flowerImage = ref('');
    const totalPrice = ref(0);

    const flowerImages = {
      sun: 'https://cdn.pixabay.com/photo/2018/08/29/22/52/sunflowers-3640938_1280.jpg',
      rose: 'https://cdn.pixabay.com/photo/2016/08/03/14/24/roses-1566792_1280.jpg',
    };

    const placeOrder = () => {
      isOrderPlaced.value = true;
      flowerImage.value = flowerImages[order.flowerName.toLowerCase()] || '';
    };

    watch(
        () => [order.flowerPrice, order.flowerQuantity],
        () => {
          totalPrice.value = order.flowerPrice * order.flowerQuantity;
        }
    );

    return {
      order,
      isOrderPlaced,
      flowerImage,
      placeOrder,
      totalPrice
    };
  }
};
</script>

<style scoped>
/* 원하는 스타일 추가 가능 */
</style>

let array = [];
array[100100] = 65;
array[10100100] = 650;
for (let index = 0; index < 1100100100; index++) {
  const element = array[index];
  if (element) {
    console.log(Math.sqrt(element))
  }
}
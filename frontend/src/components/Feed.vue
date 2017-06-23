<template>
  <div class="hello">
        <ul>
        <li class="tweet" v-for="tweet in tweets">
            <tweet :tweet="tweet" :currentUser="currentUser" @retweeted="retweet"/>
        </li>
        </ul>
   </div>

</template>

<script>
import Tweet from './Tweet'
export default {
  name: 'feed',
  components: {Tweet},
  props: ['tweets','currentUser'],
  methods: {
    retweet: function(id){
      this.$emit('retweeted', id)
    }
  }

}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: block;
  margin: 0 10px;
}
li.tweet:first-child {
border-top-width: 1px;
}

li.tweet {
border-style: solid;
border-width: 0 1px 1px 1px;
border-color: gray;
width: 500px;
margin: auto;
}
</style>



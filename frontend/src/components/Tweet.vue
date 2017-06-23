<template>
  <div class="tweet">
<div>
  <div><strong> {{tweet.auteur.prenom}} {{tweet.auteur.nom}}</strong>  <span class="handle">{{tweet.auteur.handle}} - {{moment(tweet.date).fromNow()}}</span></div>
  <div>contenu :{{tweet.contenu}}<br><br></div>
  <div><ul>
  <li class="button"><icon name="reply"/></li>
  <a @click="retweet(tweet.id)"><li class="button" ><icon name="retweet"/></li></a><span class="aside">{{tweet.retweeters.length}}</span>

  <li class="button"><icon name="heart"/></li>
  <li class="button"><icon name="envelope"/></li>
  </ul></div>


</div>
   </div>

</template>

<script>
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'
import moment from 'moment'
export default {
  name: 'tweet',
  props: ['tweet'],
  components: {Icon, moment},
  methods:{
    moment: function(date){
    return moment(date);
    },
    funcRetweet: function(){
      rt = rt +1;
    },
     retweet : function(id){

      var body = new FormData();
      body.append("utilisateur","Lulu");
      body.append("tweet",id);
       this.$http.post('http://localhost:8080/retweet',body).then(response => {
         console.log(response);
         this.$emit('retweeted', id)
       }, response => {
       console.log(response);
       //error callback
     });
    }
  },
  data () {
    return {
      rt: 0,
      retweets: []
    }
  }
}
</script>

<style scoped>
li:hover {
    cursor: pointer //on hover change the cursor to pointer
}
li.button {
 display: inline-block;
}

a {
 color: #42b983;
 cursor : pointer;
}

span.handle {
 color: gray;
}
</style>

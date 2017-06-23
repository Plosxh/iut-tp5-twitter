<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
     <div><strong>Utilisateur connecté : {{currentUser}}</strong></div>
    <utilisateur :utilisateurs="utilisateurs" @selected_utilisateur="selected"/>
    <div v-if="loading">Loading TOTO</div>
    <div v-else>
    <feed :tweets="tweets"  :currentUser="currentUser" @retweeted="retweet"/>
    </div>
   </div>

</template>

<script>
import Feed from './Feed'

import utilisateur from './utilisateur'
import Vue from 'vue'
import Resource from 'vue-resource'
Vue.use(Resource)
export default {
  name: 'hello',
  components: {Feed, utilisateur},
  methods :{
  fetchTweets : function (){
      this.$http.get('http://localhost:8080/list').then(response => {

        // get body data
        this.tweets = response.body;
        //console.log(response.body);
        //console.log(response.body[0].getRetweeters().Length())
        this.loading = false;

      }, response => {
        // error callback
        this.loading = true;
      });
    },
  retweet: function(id){
    //alert(this.tweets[0]);
    //alert(id);
    var i;
    for(i=0; i<this.tweets.length; i++){
      if(this.tweets[i].id == id){this.tweets[i].retweeters.push({handle:this.currentUser});}
    }
    //this.fetchTweets()
   },
   selected: function(select){
    this.currentUser = select;
    //alert(current_user)
   },
  fetchUtilisateurs : function (){
      this.$http.get('http://localhost:8080/utilisateurs').then(response => {

        // get body data
        this.utilisateurs = response.body;
        console.log(response.body);
      }, response => {
        // error callback
      });
    }
  },
  data () {
    return {
      loading : true,
      tweets: [],
      utilisateurs: [],
      currentUser: "Anonyme"
    }
  },
  created () {
   this.fetchTweets()
   this.fetchUtilisateurs()
  }
}
</script>

<style scoped>

</style>

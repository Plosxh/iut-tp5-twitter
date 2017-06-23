<template>
  <div class="utilisateur">
  <span>Selectionner un utilisateur</span>
  <select @change="onChange($event.target.value)">
   <option disabled value="">Choisissez un utilisateur ...</option>
   <option v-for="utilisateur in utilisateurs" :value="utilisateur.handle">
     {{ utilisateur.prenom }} {{ utilisateur.nom }}
   </option>
  </select>
   </div>

</template>

<script>

export default {
  name: 'utilisateur',
  props: ['utilisateurs'],

  methods: {
    onChange: function(select){
      this.utilisateur_selected = select;
      //alert(this.utilisateur_selected)
      this.$emit('selected_utilisateur', select);
    }
  },
   data () {
     return {
     utilisateur_selected: "Anonyme"
     }
   }
}
</script>

const myApp = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            counter: 1,
            message: "Hello",
            list: [10, 20, 30],
            axios: null,
            movies : [],
            movie : "",
        }
    },

    // Mise en place de l'application
    mounted() {
        console.log("Mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/api/',
            timeout: 1000,
            headers: { 'Content-Type': 'application/json' },
        });
        this.getMovies()
    },

    methods: {
        // Place pour les futures méthodes
        incCounter: function(step) {
            console.log("incremente le compteur ");
            this.counter += step;
            this.axios.get('/movies/1')
                .then(r => {
                    console.log("read movie 1 done");
                    this.message = r.data;
                });
        },
        getMovies: function (){
            this.axios.get('/movies')
                .then(r => {
                    console.log("get movies done");
                    this.movies = r.data;
                });
        },
        deleteMovie: function (id) {
            this.axios.delete('/movies/'+id)
                .then(r => {
                    console.log("delete movie "+id+" done");
                    this.getMovies()});

            
        },
        showMovie: function (id) {
            this.axios.get('/movies/'+id)
                .then(r => {
                    console.log("show movie "+id+" done");
                    this.movie = r.data});


        }

    }
}

Vue.createApp(myApp).mount('#myApp');
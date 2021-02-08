new Vue({
    el:"#app",
    data:{
        dialogVisible:false,
        commodity:{
            comName:'',
            taste:''

        },
        commoditys:[]
    },
    mounted: function (){
        var _this = this;
        axios.get("http://localhost:8099/app/food/commodity/selectAllCom.do")
            .then(function (response){
                _this.commoditys = response.data;
            })
    },
    methods:{
        rejister: function () {
            axios.put("http://localhost:8099/app/food/commodity/")
                .then(function (response){
                    _this.commoditys = response.data;
                })
        }

    }
})
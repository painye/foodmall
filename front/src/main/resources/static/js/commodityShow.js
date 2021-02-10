new Vue({
    el: "#app",
    data:{
        currentId:'',
        currentUserId:'',
        commodity: {
            id:'',
            comNumber:'',
            comName:'',
            category: {
                categoryId:'',
                categoryName:'',
                categoryMessage:'',
                composition:''
            },
            message:'',
            price:'',
            image:'',
            exTime:'',
            taste:'',
            mfrsNumber:'',
            pack:'',
            weight:'',
            grade:'',
            createTime:'',
            updateTime:'',
            deleteEnable:''
        },

       comStores:[]
    },
    mounted:function () {
        var _this = this;
        var myUrl = window.location.href;
        let param = myUrl.substr(myUrl.lastIndexOf("?") + 1).split("&");
        this.currentId = param[0].substr(param[0].indexOf("=")+1);
        this.currentUserId=param[1].substr(param[1].indexOf("=")+1);
        axios.get("http://localhost:8099/app/food/commodity/findCommodityOneByNumber.do?comId="+_this.currentId)
            .then(function (response){
                _this.commodity = response.data;
            })
    },
    methods:{
        goBack: function () {
            window.open("http://localhost:63342/foodmall/front/static/html/index1.html?_ijt=770qf866d8431jg59hc263fhcv?userId="+this.currentUserId);

        },

        search:function (comId) {
            var _this = this;
            axios.get("http://localhost:8096/app/com_store/selectComStoreByComId.do?comId="+_this.currentId)
                .then(function (response){
                    _this.comStores = response.data;
                })

        }
    }
})
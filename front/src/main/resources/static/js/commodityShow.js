new Vue({
    el: "#app",
    data:{
        currentId:'',
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

        comStore:{
            comStoreId:'',

        }
    },
    mounted:function () {
        var _this = this;
        var myUrl = window.location.href;
        _this.currentId = myUrl.substr(myUrl.lastIndexOf("=") + 1).split("&");
        axios.get("http://localhost:8099/app/food/commodity/findCommodityOneByNumber.do?comId="+_this.currentId)
            .then(function (response){
                _this.commodity = response.data;
            })
    },
    methods:{
        goBack: function () {
            window.open("http://localhost:63342/foodmall/front/static/html/index1.html?_ijt=770qf866d8431jg59hc263fhcv");

        }
    }
})
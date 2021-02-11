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

       comStores:[],

        order:{
            orderId:'',
            user:{
                userId:'',
                userName:'',
                userPassword:'',
                userPhone:'',
                userImage:'',
                money:'',
                moneyPassword:'',
                userAddress:'',
                createTime:'',
                deleteEnable:''
            },
            comStore:{
                comStoreId:'',
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
                store:{
                    storeId:'',
                    storeName:'',
                    storeGrade:'',
                    license:'',
                    phone:'',
                    createTime:'',
                    management:'',
                    deleteEnable:'',
                    updateTime:''
                },
                salePrice:'',
                stock:'',
                sales:'',
                createTime:'',
                updateTime:'',
                deleteEnable:'',
            },
            price:'',
            count:'',
            status:'',
            createTime:'',
            updateTime:'',
            delete_enable:''
        }
    },
    mounted:function () {
        var _this = this;
        var myUrl = window.location.href;
        let param = myUrl.substr(myUrl.lastIndexOf("?") + 1).split("&");
        this.currentId = param[0].substr(param[0].indexOf("=")+1);
        this.currentUserId=param[1].substr(param[1].indexOf("=")+1);
        axios.get("http://localhost:8099/app/food/commodity/findCommodityOneByNumber.do?comId="+_this.currentId)
            .then(function (response){
                _this.order.comStore.commodity = response.data;
            })
        axios({
            method:"get",
            url:"http://localhost:8098/app/user/selectUserById.do?userId="+_this.currentUserId,
        }).then(function (response) {
            _this.order.user = response.data;
        })
    },
    methods:{
        goBack: function () {
            window.open("http://localhost:8095/html/index1.html?userId="+this.currentUserId);

        },

        search:function (comId) {
            var _this = this;
            axios.get("http://localhost:8096/app/com_store/selectComStoreByComId.do?comId="+_this.currentId)
                .then(function (response){
                    _this.comStores = response.data;
                })

        },
        purchase:function(comstore){
            var _this= this;
            alert(comstore.comStoreId);
            axios({
                method:"put",
                url:"http://localhost:8098/app/foodmall/user/order/insertOrder.do"
            })
        }
    }
})
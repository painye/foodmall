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
        },

        ruleForm:{
            name:'',
            pass:''
        },

        dialogVisible1:false,
        currentUserName:'',
        currentMoneyPassword:''
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
            var currentCategoryId = _this.order.comStore.commodity.category.categoryId
            _this.order.comStore=comstore;
            _this.order.comStore.commodity.category.categoryId = currentCategoryId
            _this.order.price=_this.order.comStore.salePrice;
            var orderId = _this.order.orderId;
            axios({
                method:"put",
                data: _this.order,
                url:"http://localhost:8098/app/foodmall/user/order/insertOrder.do"
            })
        },
        pay:function () {
            var _this=this;
            axios({
                method:"post",
                params: {
                    userId: _this.order.user.userId + "",
                    userName: _this.currentUserName,
                    moneyPassword: _this.currentMoneyPassword
                },
                url:"http://localhost:8098/app/foodmall/user/order/buyLast.do"
            }).then(function (response){
                if(response.data = 1){
                    alert("购买成功")
                }else   alert("购买失败，密码错误")
            })

        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
})
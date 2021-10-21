Page({
  data: {
    userInfo: '',
    userIsLogin: false,
  },

  toRegister(){
    wx.navigateTo({
      url: '../login/register',
    })
  },

  login() {
    
    wx.getUserProfile({
      desc: '必须授权登录才能使用',
      success: res => {
        let user = res.userInfo
        console.log("用户信息：", user)
        this.setData({
          userInfo: user,
          userIsLogin:true
        })

        //将数据进行本地缓存
        wx.setStorage({
          key:"userInfo",
          data:this.data.userInfo
        })

        wx.navigateTo({
          url: '../login/register',
        })


        //将用户登录数据返回后端
        wx.request({
          url: 'http://localhost:8080/SSMSubmit_war_exploded/getWXInfo',
          data:{
            user:user,
            username:user.nickName,
            userTX:user.avatarUrl,
          },
          header: {
            // 'content-type': 'application/json' // 默认值
             'Content-Type': 'application/x-www-form-urlencoded'
           },
           method:'POST',
           success: res =>{
              wx.showToast({
                title: '后端已接收',
              }),
              //跳转至注册页面
              wx.reLaunch({
                url: '../main/main.wxml',
              })
           },
           fail: res=>{
             wx.showToast({
               title: '失败',
             })
            
           }
        })
      },

      fail: res => {
        console.log('授权失败！',res)
        
      }
    })

    
  },

  inToMain(){
    wx.switchTab({
      url: '../main/main',
    })
  }

})
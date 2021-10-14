// index.js
// 获取应用实例


Page({
  //吃太二酸菜鱼
  sb(){
    console.log("傻逼张紫薇爱吃酸菜鱼")
  },
  //吃必胜客
  xb(){
    wx.showToast({
      title: '傻逼张紫薇爱吃必胜客',
    })
  },
  //吃萨莉亚
  cb(){
    wx.showToast({
      title: '菜逼张紫薇要请问吃萨莉亚',
    })
  },

  ss(){
    wx.showToast({
      title: '张紫薇要请我吃拓海厨房',
    })
  },


  getInfo(){
    wx.request({
      url: 'https://www.localhost/wxTest', 
      method: 'POST',
      data:{},
      header: {
       // 'content-type': 'application/json' // 默认值
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      
      success(res) {
        console.log(res.data)
      },
     
    })

  },
  
})

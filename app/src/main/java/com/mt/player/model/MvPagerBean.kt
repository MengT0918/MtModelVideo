package com.mt.player.model

data class MvPagerBean(var totalCount: Int, var videos: List<VideosBean>)
data class VideosBean(var title: String, var description: String, var posterPic: String)
data class ArtistsBean(var artistId: Int, var artistName: String)
//class MvPagerBean {
//    var totalCount: Int = 0
//    var videos: List<VideosBean>? = null
//
//    class VideosBean {
//
//        var id: Int = 0
//        var title: String? = null
//        var description: String? = null
//        var artistName: String? = null
//        var posterPic: String? = null
//        var thumbnailPic: String? = null
//        var albumImg: String? = null
//        var regdate: String? = null
//        var videoSourceTypeName: String? = null
//        var totalViews: Int = 0
//        var totalPcViews: Int = 0
//        var totalMobileViews: Int = 0
//        var totalComments: Int = 0
//        var url: String? = null
//        var hdUrl: String? = null
//        var uhdUrl: String? = null
//        var shdUrl: String? = null
//        var videoSize: Int = 0
//        var hdVideoSize: Int = 0
//        var uhdVideoSize: Int = 0
//        var shdVideoSize: Int = 0
//        var duration: Int = 0
//        var status: Int = 0
//        var linkId: Int = 0
//        var playListPic: String? = null
//        var artists: List<ArtistsBean>? = null
//
//        class ArtistsBean {
//            var artistId: Int = 0
//            var artistName: String? = null
//        }
//    }
//}

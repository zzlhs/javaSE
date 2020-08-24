## 流式传输：就是客户端通过链接视频服务器实时传输音、视频信息，实现“边下载边播放”。 

### 1 顺序流式传输

	即顺序下载音、视频文件，可以实现边下载边播放，不过，用户只能观看已下载的视频内容，无法快进到未  
下载的视频部分，顺序流式传输可以使用Http服务器来实现，比如Nginx、Apache等  

### 2 实时流式传输

	实时流式传输可以解决顺序流式传输无法快进的问题，它与Http流式传输不同，它必须使用流媒体服务器并  
且使用流媒体协议来传输视频，它比Http流式传输复杂。常见的实时流式传输协议有RTSP、RTMP、RSVP 等。  

## 流媒体系统结构

![Image text](https://github.com/zhengyuanfeng521/javaSE/blob/master/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97/RabbitMQ/images/rabbitMQ%E5%9F%BA%E6%9C%AC%E7%BB%93%E6%9E%84.png)
 
 
## 点播方案

包括点播和直播两种方式，我们先调研点播的方案，如下：  
1、 播放器通过 http协议从http服务器上下载视频文件进行播放    
问题：必须等到视频下载完才可以播放，不支持快进到某个时间点进行播放  
2、 播放器通过rtmp协议连接媒体服务器以实时流方式播放视频 使用rtmp协议需要架设媒体服务器，造价高，对于直播多采用此方案。  
3、 播放器使用HLS协议连接http服务器（Nginx、Apache等）实现近实时流方式播放视频 HLS协议规定：基于Http协议，视频封装格式  
为ts，视频的编码格式为H264,音频编码格式为MP3、AAC或者AC3。 

## 视频编码&文件格式

	音视频编码格式：通过音视频的压缩技术，将视频格式转换成另一种视频格式，通过视频编码实现流媒体的传输。  
比如：一个.avi的视频文件

	文件格式：即使常说MP3、MP4之类的
	
## ffmpeg -- 流媒体工具

### 将一个 .avi 文件转成 MP4格式的文件，转成其他格式同理

window下命令行中即可运行

```
ﬀmpeg -i test.avi test.mp4 
```

### 生成m3u8/ts文件

MP4的生成  
```
ffmpeg.exe ‐i  test.avi ‐c:v libx264 ‐s 1280x720 ‐pix_fmt yuv420p ‐b:a 63k ‐b:v 753k ‐r 18  .\test.mp4  
```

m3u8的生成

```
ffmpeg ‐i  lucene.mp4   ‐hls_time 10 ‐hls_list_size 0  ‐hls_segment_filename  ./hls/lucene_%05d.ts ./hls/lucene.m3u8
```
<html>
	<head>
		<script type="text/javascript" src="http://wave-api.appspot.com/public/embed.js"></script>
	</head>
	<body>
		<div id="wave" style="width: 100%; height: 100%"></div>
		<script type="text/javascript">
		  var wave = new WavePanel('https://wave.google.com/wave/');
		  wave.setUIConfig('white', 'black', 'Arial', '13px');
		  wave.loadWave("<%= request.getParameter("id")!=null?request.getParameter("id"):"googlewave.com!w+YaAsHHfXC" %>");
		  wave.init(document.getElementById('wave'));
		</script>
	</body>
</html>
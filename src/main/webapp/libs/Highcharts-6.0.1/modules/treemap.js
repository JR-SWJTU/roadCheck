/*
 Highcharts JS v6.0.1 (2017-10-05)

 (c) 2014 Highsoft AS
 Authors: Jon Arild Nygard / Oystein Moseng

 License: www.highcharts.com/license
*/
(function(r){"object"===typeof module&&module.exports?module.exports=r:r(Highcharts)})(function(r){var E=function(c){var r=c.each,w=c.extend,m=c.pick;return{getColor:function(p,n){var D=n.index,g=n.levelMap,k=n.parentColor,r=n.parentColorIndex,t=n.series,q=n.colors,w=n.siblings,f=t.points,l,B,y;if(p){f=f[p.i];p=g[p.levelDynamic]||{};(l=f&&("boolean"===typeof p.colorByPoint?p.colorByPoint:!!t.options.colorByPoint))&&(B=q[f.index%q.length]);q=f&&f.options.color;l=p&&p.color;if(g=k)g=(g=p&&p.colorVariation)&&
"brightness"===g.key?c.color(k).brighten(D/w*g.to).get():k;l=m(q,l,B,g,t.color);y=m(f&&f.options.colorIndex,p&&p.colorIndex,r,n.colorIndex)}return{color:l,colorIndex:y}},setTreeValues:function n(c,g){var k=g.before,z=g.idRoot,t=g.mapIdToNode[z],q=g.points[c.i],A=q&&q.options||{},f=0,l=[];w(c,{levelDynamic:c.level-(("boolean"===typeof g.levelIsConstant?g.levelIsConstant:1)?0:t.level),name:m(q&&q.name,""),visible:z===c.id||("boolean"===typeof g.visible?g.visible:!1)});"function"===typeof k&&(c=k(c,
g));r(c.children,function(k,m){var q=w({},g);w(q,{index:m,siblings:c.children.length,visible:c.visible});k=n(k,q);l.push(k);k.visible&&(f+=k.val)});c.visible=0<f||c.visible;k=m(A.value,f);w(c,{children:l,childrenTotal:f,isLeaf:c.visible&&!f,val:k});return c}}}(r);(function(c,r){var w=c.seriesType,m=c.seriesTypes,p=c.map,n=c.merge,D=c.extend,g=c.noop,k=c.each,z=r.getColor,t=c.grep,q=c.isNumber,A=c.isString,f=c.pick,l=c.Series,B=c.stableSort,y=c.Color,E=function(a,b,d){d=d||this;c.objectEach(a,function(h,
e){b.call(d,h,e,a)})},F=c.reduce,C=function(a,b,d){d=d||this;a=b.call(d,a);!1!==a&&C(a,b,d)};w("treemap","scatter",{showInLegend:!1,marker:!1,dataLabels:{enabled:!0,defer:!1,verticalAlign:"middle",formatter:function(){return this.point.name||this.point.id},inside:!0},tooltip:{headerFormat:"",pointFormat:"\x3cb\x3e{point.name}\x3c/b\x3e: {point.value}\x3cbr/\x3e"},ignoreHiddenPoint:!0,layoutAlgorithm:"sliceAndDice",layoutStartingDirection:"vertical",alternateStartingDirection:!1,levelIsConstant:!0,
drillUpButton:{position:{align:"right",x:-10,y:10}},borderColor:"#e6e6e6",borderWidth:1,opacity:.15,states:{hover:{borderColor:"#999999",brightness:m.heatmap?0:.1,halo:!1,opacity:.75,shadow:!1}}},{pointArrayMap:["value"],axisTypes:m.heatmap?["xAxis","yAxis","colorAxis"]:["xAxis","yAxis"],directTouch:!0,optionalAxis:"colorAxis",getSymbol:g,parallelArrays:["x","y","value","colorValue"],colorKey:"colorValue",translateColors:m.heatmap&&m.heatmap.prototype.translateColors,colorAttribs:m.heatmap&&m.heatmap.prototype.colorAttribs,
trackerGroups:["group","dataLabelsGroup"],getListOfParents:function(a,b){a=F(a||[],function(a,b,e){b=f(b.parent,"");void 0===a[b]&&(a[b]=[]);a[b].push(e);return a},{});E(a,function(a,h,e){""!==h&&-1===c.inArray(h,b)&&(k(a,function(a){e[""].push(a)}),delete e[h])});return a},getTree:function(){var a=p(this.data,function(a){return a.id}),a=this.getListOfParents(this.data,a);this.nodeMap=[];return this.buildNode("",-1,0,a,null)},init:function(a,b){l.prototype.init.call(this,a,b);this.options.allowDrillToNode&&
c.addEvent(this,"click",this.onClickDrillToNode)},buildNode:function(a,b,d,h,e){var v=this,x=[],c=v.points[b],G=0,f;k(h[a]||[],function(b){f=v.buildNode(v.points[b].id,b,d+1,h,a);G=Math.max(f.height+1,G);x.push(f)});b={id:a,i:b,children:x,height:G,level:d,parent:e,visible:!1};v.nodeMap[b.id]=b;c&&(c.node=b);return b},setTreeValues:function(a){var b=this,d=b.options,h=0,e=[],v,c=b.points[a.i];k(a.children,function(a){a=b.setTreeValues(a);e.push(a);a.ignore||(h+=a.val)});B(e,function(a,b){return a.sortIndex-
b.sortIndex});v=f(c&&c.options.value,h);c&&(c.value=v);D(a,{children:e,childrenTotal:h,ignore:!(f(c&&c.visible,!0)&&0<v),isLeaf:a.visible&&!h,levelDynamic:a.level-(d.levelIsConstant?b.nodeMap[b.rootNode].level:0),name:f(c&&c.name,""),sortIndex:f(c&&c.sortIndex,-v),val:v});return a},calculateChildrenAreas:function(a,b){var d=this,h=d.options,e=this.levelMap[a.levelDynamic+1],v=f(d[e&&e.layoutAlgorithm]&&e.layoutAlgorithm,h.layoutAlgorithm),c=h.alternateStartingDirection,H=[];a=t(a.children,function(a){return!a.ignore});
e&&e.layoutStartingDirection&&(b.direction="vertical"===e.layoutStartingDirection?0:1);H=d[v](b,a);k(a,function(a,e){e=H[e];a.values=n(e,{val:a.childrenTotal,direction:c?1-b.direction:b.direction});a.pointValues=n(e,{x:e.x/d.axisRatio,width:e.width/d.axisRatio});a.children.length&&d.calculateChildrenAreas(a,a.values)})},setPointValues:function(){var a=this,b=a.xAxis,d=a.yAxis;k(a.points,function(h){var e=h.node,c=e.pointValues,x,f,k;k=(a.pointAttribs(h)["stroke-width"]||0)%2/2;c&&e.visible?(e=Math.round(b.translate(c.x,
0,0,0,1))-k,x=Math.round(b.translate(c.x+c.width,0,0,0,1))-k,f=Math.round(d.translate(c.y,0,0,0,1))-k,c=Math.round(d.translate(c.y+c.height,0,0,0,1))-k,h.shapeType="rect",h.shapeArgs={x:Math.min(e,x),y:Math.min(f,c),width:Math.abs(x-e),height:Math.abs(c-f)},h.plotX=h.shapeArgs.x+h.shapeArgs.width/2,h.plotY=h.shapeArgs.y+h.shapeArgs.height/2):(delete h.plotX,delete h.plotY)})},setColorRecursive:function(a,b,d,c,e){var h=this,f=h&&h.chart,f=f&&f.options&&f.options.colors,g;if(a){g=z(a,{colors:f,index:c,
levelMap:h.levelMap,parentColor:b,parentColorIndex:d,series:h,siblings:e});if(b=h.points[a.i])b.color=g.color,b.colorIndex=g.colorIndex;k(a.children||[],function(b,d){h.setColorRecursive(b,g.color,g.colorIndex,d,a.children.length)})}},algorithmGroup:function(a,b,d,c){this.height=a;this.width=b;this.plot=c;this.startDirection=this.direction=d;this.lH=this.nH=this.lW=this.nW=this.total=0;this.elArr=[];this.lP={total:0,lH:0,nH:0,lW:0,nW:0,nR:0,lR:0,aspectRatio:function(a,b){return Math.max(a/b,b/a)}};
this.addElement=function(a){this.lP.total=this.elArr[this.elArr.length-1];this.total+=a;0===this.direction?(this.lW=this.nW,this.lP.lH=this.lP.total/this.lW,this.lP.lR=this.lP.aspectRatio(this.lW,this.lP.lH),this.nW=this.total/this.height,this.lP.nH=this.lP.total/this.nW,this.lP.nR=this.lP.aspectRatio(this.nW,this.lP.nH)):(this.lH=this.nH,this.lP.lW=this.lP.total/this.lH,this.lP.lR=this.lP.aspectRatio(this.lP.lW,this.lH),this.nH=this.total/this.width,this.lP.nW=this.lP.total/this.nH,this.lP.nR=this.lP.aspectRatio(this.lP.nW,
this.nH));this.elArr.push(a)};this.reset=function(){this.lW=this.nW=0;this.elArr=[];this.total=0}},algorithmCalcPoints:function(a,b,d,c){var e,h,f,g,m=d.lW,n=d.lH,u=d.plot,l,p=0,q=d.elArr.length-1;b?(m=d.nW,n=d.nH):l=d.elArr[d.elArr.length-1];k(d.elArr,function(a){if(b||p<q)0===d.direction?(e=u.x,h=u.y,f=m,g=a/f):(e=u.x,h=u.y,g=n,f=a/g),c.push({x:e,y:h,width:f,height:g}),0===d.direction?u.y+=g:u.x+=f;p+=1});d.reset();0===d.direction?d.width-=m:d.height-=n;u.y=u.parent.y+(u.parent.height-d.height);
u.x=u.parent.x+(u.parent.width-d.width);a&&(d.direction=1-d.direction);b||d.addElement(l)},algorithmLowAspectRatio:function(a,b,d){var c=[],e=this,f,g={x:b.x,y:b.y,parent:b},m=0,n=d.length-1,l=new this.algorithmGroup(b.height,b.width,b.direction,g);k(d,function(d){f=d.val/b.val*b.height*b.width;l.addElement(f);l.lP.nR>l.lP.lR&&e.algorithmCalcPoints(a,!1,l,c,g);m===n&&e.algorithmCalcPoints(a,!0,l,c,g);m+=1});return c},algorithmFill:function(a,b,d){var c=[],e,f=b.direction,g=b.x,l=b.y,m=b.width,n=b.height,
p,q,r,t;k(d,function(d){e=d.val/b.val*b.height*b.width;p=g;q=l;0===f?(t=n,r=e/t,m-=r,g+=r):(r=m,t=e/r,n-=t,l+=t);c.push({x:p,y:q,width:r,height:t});a&&(f=1-f)});return c},strip:function(a,b){return this.algorithmLowAspectRatio(!1,a,b)},squarified:function(a,b){return this.algorithmLowAspectRatio(!0,a,b)},sliceAndDice:function(a,b){return this.algorithmFill(!0,a,b)},stripes:function(a,b){return this.algorithmFill(!1,a,b)},translate:function(){var a=this,b=a.rootNode=f(a.rootNode,a.options.rootId,""),
d,c;l.prototype.translate.call(a);a.levelMap=F(a.options.levels||[],function(a,b){a[b.level]=b;return a},{});c=a.tree=a.getTree();d=a.nodeMap[b];""===b||d&&d.children.length||(a.drillToNode("",!1),b=a.rootNode,d=a.nodeMap[b]);C(a.nodeMap[a.rootNode],function(b){var d=!1,c=b.parent;b.visible=!0;if(c||""===c)d=a.nodeMap[c];return d});C(a.nodeMap[a.rootNode].children,function(a){var b=!1;k(a,function(a){a.visible=!0;a.children.length&&(b=(b||[]).concat(a.children))});return b});a.setTreeValues(c);a.axisRatio=
a.xAxis.len/a.yAxis.len;a.nodeMap[""].pointValues=b={x:0,y:0,width:100,height:100};a.nodeMap[""].values=b=n(b,{width:b.width*a.axisRatio,direction:"vertical"===a.options.layoutStartingDirection?0:1,val:c.val});a.calculateChildrenAreas(c,b);a.colorAxis?a.translateColors():a.options.colorByPoint||a.setColorRecursive(a.tree);a.options.allowDrillToNode&&(d=d.pointValues,a.xAxis.setExtremes(d.x,d.x+d.width,!1),a.yAxis.setExtremes(d.y,d.y+d.height,!1),a.xAxis.setScale(),a.yAxis.setScale());a.setPointValues()},
drawDataLabels:function(){var a=this,b=t(a.points,function(a){return a.node.visible}),d,c;k(b,function(b){c=a.levelMap[b.node.levelDynamic];d={style:{}};b.node.isLeaf||(d.enabled=!1);c&&c.dataLabels&&(d=n(d,c.dataLabels),a._hasPointLabels=!0);b.shapeArgs&&(d.style.width=b.shapeArgs.width,b.dataLabel&&b.dataLabel.css({width:b.shapeArgs.width+"px"}));b.dlOptions=n(d,b.options.dataLabels)});l.prototype.drawDataLabels.call(this)},alignDataLabel:function(a){m.column.prototype.alignDataLabel.apply(this,
arguments);a.dataLabel&&a.dataLabel.attr({zIndex:(a.node.zIndex||0)+1})},pointAttribs:function(a,b){var d=a&&this.levelMap[a.node.levelDynamic]||{},c=this.options,e=b&&c.states[b]||{},g=a&&a.getClassName()||"";a={stroke:a&&a.borderColor||d.borderColor||e.borderColor||c.borderColor,"stroke-width":f(a&&a.borderWidth,d.borderWidth,e.borderWidth,c.borderWidth),dashstyle:a&&a.borderDashStyle||d.borderDashStyle||e.borderDashStyle||c.borderDashStyle,fill:a&&a.color||this.color};-1!==g.indexOf("highcharts-above-level")?
(a.fill="none",a["stroke-width"]=0):-1!==g.indexOf("highcharts-internal-node-interactive")?(b=f(e.opacity,c.opacity),a.fill=y(a.fill).setOpacity(b).get(),a.cursor="pointer"):-1!==g.indexOf("highcharts-internal-node")?a.fill="none":b&&(a.fill=y(a.fill).brighten(e.brightness).get());return a},drawPoints:function(){var a=this,b=t(a.points,function(a){return a.node.visible});k(b,function(b){var d="level-group-"+b.node.levelDynamic;a[d]||(a[d]=a.chart.renderer.g(d).attr({zIndex:1E3-b.node.levelDynamic}).add(a.group));
b.group=a[d]});m.column.prototype.drawPoints.call(this);a.options.allowDrillToNode&&k(b,function(b){b.graphic&&(b.drillId=a.options.interactByLeaf?a.drillToByLeaf(b):a.drillToByGroup(b))})},onClickDrillToNode:function(a){var b=(a=a.point)&&a.drillId;A(b)&&(a.setState(""),this.drillToNode(b))},drillToByGroup:function(a){var b=!1;1!==a.node.level-this.nodeMap[this.rootNode].level||a.node.isLeaf||(b=a.id);return b},drillToByLeaf:function(a){var b=!1;if(a.node.parent!==this.rootNode&&a.node.isLeaf)for(a=
a.node;!b;)a=this.nodeMap[a.parent],a.parent===this.rootNode&&(b=a.id);return b},drillUp:function(){var a=this.nodeMap[this.rootNode];a&&A(a.parent)&&this.drillToNode(a.parent)},drillToNode:function(a,b){var d=this.nodeMap[a];this.idPreviousRoot=this.rootNode;this.rootNode=a;""===a?this.drillUpButton=this.drillUpButton.destroy():this.showDrillUpButton(d&&d.name||a);this.isDirty=!0;f(b,!0)&&this.chart.redraw()},showDrillUpButton:function(a){var b=this;a=a||"\x3c Back";var d=b.options.drillUpButton,
c,e;d.text&&(a=d.text);this.drillUpButton?this.drillUpButton.attr({text:a}).align():(e=(c=d.theme)&&c.states,this.drillUpButton=this.chart.renderer.button(a,null,null,function(){b.drillUp()},c,e&&e.hover,e&&e.select).attr({align:d.position.align,zIndex:7}).add().align(d.position,!1,d.relativeTo||"plotBox"))},buildKDTree:g,drawLegendSymbol:c.LegendSymbolMixin.drawRectangle,getExtremes:function(){l.prototype.getExtremes.call(this,this.colorValueData);this.valueMin=this.dataMin;this.valueMax=this.dataMax;
l.prototype.getExtremes.call(this)},getExtremesFromAll:!0,bindAxes:function(){var a={endOnTick:!1,gridLineWidth:0,lineWidth:0,min:0,dataMin:0,minPadding:0,max:100,dataMax:100,maxPadding:0,startOnTick:!1,title:null,tickPositions:[]};l.prototype.bindAxes.call(this);c.extend(this.yAxis.options,a);c.extend(this.xAxis.options,a)},utils:{recursive:C,reduce:F}},{getClassName:function(){var a=c.Point.prototype.getClassName.call(this),b=this.series,d=b.options;this.node.level<=b.nodeMap[b.rootNode].level?
a+=" highcharts-above-level":this.node.isLeaf||f(d.interactByLeaf,!d.allowDrillToNode)?this.node.isLeaf||(a+=" highcharts-internal-node"):a+=" highcharts-internal-node-interactive";return a},isValid:function(){return this.id||q(this.value)},setState:function(a){c.Point.prototype.setState.call(this,a);this.graphic&&this.graphic.attr({zIndex:"hover"===a?1:0})},setVisible:m.pie.prototype.pointClass.prototype.setVisible})})(r,E)});

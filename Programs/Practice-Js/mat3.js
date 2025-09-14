function corners(mat){
  let r=mat.length,c=mat[0].length;
  let corners=[mat[0][0],mat[0][c-1],mat[r-1][0],mat[r-1][c-1]];
  console.log("Corners:",...corners);
  console.log("Sum:",corners.reduce((a,b)=>a+b,0));
}
corners([[6,4,6,9],[2,6,1,8],[5,5,2,2],[4,4,1,3]]);

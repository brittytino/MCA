function isSparse(mat){
  let rows=mat.length, cols=mat[0].length;
  let zeros=0, total=rows*cols;
  for(let r of mat) for(let v of r) if(v===0) zeros++;
  console.log(zeros>(total/2)?"Sparse":"Not Sparse");
}

isSparse([[1,0,3],[0,0,4],[6,0,0]]);

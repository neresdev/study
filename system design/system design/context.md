# Projeto - Construir um encurtador de URL

## Requisitos
 - Receber uma URL de entrada e devolver uma URL de saída
 - A URL de saída vai conter até 6 caracteres
 - Quando a URL encurtada foi chamada, a aplicação deverá receber essa URL encurtada e redirecionar para a url original
 - As URLs curtas podem expirar
 - Os links gerados não podem ser advinhaveis
 - A geração é em tempo real e com o mínimo de latência possível

## Cenário 1
 - 10 novas URLs por minuto
 - Ratio de leitura e escrita em 50:1
 - Estimado em 500 RPM (Requests por minuto)
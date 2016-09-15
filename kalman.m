%values
s1 = [375.5 373.3 373.1 372.5 372.9 373.1 374.5 373.9 374.4 374.2];
s2 = [350 417 374 382.5 356.8 360.3 362.6 359.6 363.3 361.5];
%number of items
n1 = size(s1)(2);
n2 = size(s2)(2);
%averages
a1 = sum(s1)/n1;
a2 = sum(s2)/n2;

%variance
v1 = sum( (s1-a1).^2 ) /n1;
v2 = sum( (s2-a1).^2 ) /n2;


%weights
total = v1+v2;
w = v2/total
